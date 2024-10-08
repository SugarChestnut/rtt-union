package cn.rentaotao.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 字节码在被加载后，都要经过一系列 transformer 转换后，再被应用到 JVM
 *
 * @author rtt
 * @date 2024/9/30 10:52
 */
public class TransformExample implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        try {
            // 判断 className 全限定类名

            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get(className);
            CtMethod[] methods = ctClass.getMethods();
            for (CtMethod method : methods) {
                method.setBody("xxx");
            }
            byte[] bytecode = ctClass.toBytecode();
            ctClass.detach();

            // 返回 class 文件字节数组
            return bytecode;
        } catch (Exception e) {
            //
        }

        return classfileBuffer;

    }
}
