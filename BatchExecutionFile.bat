D:
for /r "D:\TESTING\AutomationProjects\Hybrid\ExecutionFiles" %%a in (*.bat) do (
   cd "%%~pa"
   call "%%~a"
)
