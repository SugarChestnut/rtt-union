package cn.rentaotao.agent;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

/**
 * Java Agent 是一个 Java 应用程序，它可以通过 Java Instrumentation API 来修改或监视正在运行的 Java 应用程序的字节码。
 *
 * @author rtt
 * @date 2024/9/30 09:53
 */
public class AgentExample {

    /**
     * 将 agent 注入到目标程序中
     * @param args
     * @throws IOException
     * @throws AttachNotSupportedException
     * @throws AgentLoadException
     * @throws AgentInitializationException
     */
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = VirtualMachine.attach("目标程序的进程号");
        vm.loadAgent("agent.jar 路径");
    }

    /**
     * JVM 启动时加载
     *
     * @param agentArgs       启动参数
     * @param instrumentation 增强操作类
     */
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("premain");
        instrumentation.addTransformer(new TransformExample());
    }

    /**
     * JVM 启动时加载
     * {@linkplain #premain(String, Instrumentation)} 不存在，则使用当前方法
     *
     * @param agentArgs 启动参数
     */
    public static void premain(String agentArgs) {
        System.out.println("premain");
    }

    /**
     * JVM 运行时加载 agent
     * 使用 {@link com.sun.tools.attach.VirtualMachine} 运行时加载
     *
     * @param agentArgs       启动参数
     * @param instrumentation 增强操作类
     */
    public static void agentMain(String agentArgs, Instrumentation instrumentation) {
        // 当通过 VirtualMachine 将 agent 注入后，就会执行这个方法
        System.out.println("agentMain");
    }

    /**
     * JVM 运行时加载 agent
     * 使用 {@link com.sun.tools.attach.VirtualMachine} 运行时加载
     *
     * @param agentArgs 启动参数
     */
    public static void agentMain(String agentArgs) {
        System.out.println("agentMain");
    }
}
