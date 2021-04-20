@echo off
echo %0
for /f "tokens=1-3 delims=\" %%i in (%0) do (java -jar  %%i\%%j\%%k\frame-topic\generator-mybatis\src\lib\mybatis-generator-core-1.3.1.jar -configfile mybatis.xml -overwrite  )
pause  