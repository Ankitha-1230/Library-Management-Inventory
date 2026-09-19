@echo off
cd /d "%~dp0.."

if not exist dist\LibraryBookInventory.jar (
    echo ==========================================
    echo JAR file not found!
    echo Please run deployment\build.bat first.
    echo ==========================================
    pause
    exit /b 1
)

echo ==========================================
echo Library Book Inventory - Run
echo ==========================================

java -jar dist\LibraryBookInventory.jar

pause