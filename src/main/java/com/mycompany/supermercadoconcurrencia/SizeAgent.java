package com.mycompany.supermercadoconcurrencia;


import java.lang.instrument.Instrumentation;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;

public class SizeAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new SizeTransformer());
    }

    private static class SizeTransformer implements ClassFileTransformer {
        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                                byte[] classfileBuffer) throws IllegalClassFormatException {
            if (className.equals("com/mycompany/supermercadoconcurrencia/Supermercado")) {
                try {
                    Class<?> supermercadoClass = Class.forName(className, true, loader);
                    Method simulateCobroMethod = supermercadoClass.getDeclaredMethod("simularCobro");
                    simulateCobroMethod.setAccessible(true);

                    byte[] newClassfileBuffer = modifySimularCobroMethod(classfileBuffer, simulateCobroMethod);
                    return newClassfileBuffer;
                } catch (ClassNotFoundException | NoSuchMethodException e) {
                    throw new IllegalClassFormatException("Failed to modify Supermercado class");
                }
            } else {
                return classfileBuffer;
            }
        }

        private byte[] modifySimularCobroMethod(byte[] classfileBuffer, Method simulateCobroMethod) {
            // Modify the classfile to add the instrumentation code
            return classfileBuffer;
        }
    }
}
