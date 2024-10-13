package acde;

import spoon.Launcher;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpoonExample {
    public static void main(String[] args) {
        Launcher launcher = new Launcher();

        launcher.addInputResource("src/main/java/acde"); //  "/className.java" spesifik class için
        launcher.buildModel();

        Factory factory = launcher.getFactory();

        List<CtType<?>> allClasses = factory.Class().getAll();

        if (!allClasses.isEmpty()) {
            System.out.println("\nClasses found:");
            Map<String, CtMethod<?>> methodSignatures = new HashMap<>(); 

            for (CtType<?> ctClass : allClasses) {
                System.out.println("Class: " + ctClass.getSimpleName() + "\n");
                ctClass.getMethods().forEach(method -> {

                    if("main".equals(method.getSimpleName())){
                        return; // eğer main varsa onu geçiyoruz (ignore)
                    }
                    String signature = getMethodSignature(method); //signature o method'un ismi ve parametre tipleri

                    if (methodSignatures.containsKey(signature)) {
                        System.out.println("ALERT: Similar method found: " + signature);
                        System.out.println(" - Original: " + methodSignatures.get(signature).getDeclaringType().getSimpleName() + "." + methodSignatures.get(signature).getSimpleName());
                        System.out.println(" - Duplicate: " + ctClass.getSimpleName() + "." + method.getSimpleName());
                    } else {
                        methodSignatures.put(signature, method);
                    }
                });
                System.out.println();
            }
        } else {
            System.out.println("No classes found");
        }
    }

    private static String getMethodSignature(CtMethod<?> method) {
        StringBuilder signature = new StringBuilder(method.getSimpleName() + "(");
        method.getParameters().forEach(param -> 
            signature.append(param.getType().getSimpleName()).append(", ")
        );
        if (method.getParameters().size() > 0) {
            signature.setLength(signature.length() - 2);
        }
        signature.append(")");
        return signature.toString();
    }
}
