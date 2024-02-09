package gb.karpenka.tasks.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;


@Aspect
public class LoggingAspect {

        @Around("execution(* gb.karpenka.tasks.services.TaskService.find*(..))")
        //Работает для findAll(), findByStatus(String status), но не работает для findById(Long id), так как он
        //вызывается изнутри класса в методе updateTaskStatus()
        public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

            String methodName = joinPoint.getSignature().getName();
            Object [] arguments = joinPoint.getArgs();

            System.out.println("Method: " + methodName +
                    "\n with parametr: " + Arrays.asList(arguments));
            Object returnedByMethod = joinPoint.proceed();
            return returnedByMethod;
        }


        @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
        //Работает для updateTaskStatus(), но не работает для findById(Long id), так как он
        //вызывается изнутри класса в методе updateTaskStatus()
        public void log(Object returnedValue) {
            System.out.println("Method executed and returned " + returnedValue);
        }
    }






