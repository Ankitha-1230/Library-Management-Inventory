@echo off
cd /d "%~dp0.."

echo ==========================================
echo Library Book Inventory - Build
echo ==========================================

if not exist build mkdir build
if not exist dist mkdir dist

echo.
echo Compiling Java source files...

javac -d build src\Book.java src\LibraryBookInventory.java

if errorlevel 1 (
    echo Build failed!
    pause
    exit /b 1
)

echo.
echo Creating executable JAR...

jar cfe dist\LibraryBookInventory.jar LibraryBookInventory -C build .

if errorlevel 1 (
    echo JAR creation failed!
    pause
    exit /b 1
)

echo.
echo Build completed successfully!
echo JAR created at:
echo dist\LibraryBookInventory.jar

pause