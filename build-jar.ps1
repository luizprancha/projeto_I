$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $root

$workDir = Join-Path $root "build"
$classesDir = Join-Path $workDir "classes"
$libsDir = Join-Path $workDir "libs-unpacked"
$manifestPath = Join-Path $workDir "MANIFEST.MF"
$outputJar = Join-Path $root "projeto_I-app.jar"

if (Test-Path $workDir) {
    Remove-Item -Recurse -Force $workDir
}
New-Item -ItemType Directory -Path $classesDir | Out-Null
New-Item -ItemType Directory -Path $libsDir | Out-Null

$sources = Get-ChildItem -Recurse -File "projeto_I/src" -Filter *.java | ForEach-Object { $_.FullName }
$classpath = "com.miglayout.swing_11.4.2.jar;com.miglayout.core_11.4.2.jar;projeto_I/lib/mysql-connector-j-9.6.0.jar"

javac -cp $classpath -d $classesDir $sources

# Copia recursos (fonts, imagens, etc.) para dentro do JAR final.
Get-ChildItem -Recurse -File "projeto_I/src" | Where-Object { $_.Extension -ne ".java" } | ForEach-Object {
    $relative = $_.FullName.Substring((Resolve-Path "projeto_I/src").Path.Length).TrimStart('\')
    $target = Join-Path $classesDir $relative
    $targetDir = Split-Path -Parent $target
    if (!(Test-Path $targetDir)) {
        New-Item -ItemType Directory -Path $targetDir | Out-Null
    }
    Copy-Item $_.FullName $target
}

Push-Location $libsDir
jar xf (Join-Path $root "com.miglayout.swing_11.4.2.jar")
jar xf (Join-Path $root "com.miglayout.core_11.4.2.jar")
jar xf (Join-Path $root "projeto_I/lib/mysql-connector-j-9.6.0.jar")
Pop-Location

Set-Content -Path $manifestPath -Value "Main-Class: main.Main"
Add-Content -Path $manifestPath -Value ""

jar cfm $outputJar $manifestPath -C $classesDir . -C $libsDir .

Write-Host "JAR gerado com sucesso em: $outputJar"
