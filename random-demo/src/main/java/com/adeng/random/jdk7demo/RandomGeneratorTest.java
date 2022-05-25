package com.adeng.random.jdk7demo;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * JDK 17 之后，抽象了  {@link RandomGenerator} 接口
 *
 * @author wengcheng on 2022/5/24
 */
public class RandomGeneratorTest {

    public static void main(String[] args) {

        // 创建 不同 随机数对象
        RandomGenerator random = RandomGeneratorFactory.of("Random").create();
//        RandomGenerator ThreadLocalRandom = RandomGeneratorFactory.of("ThreadLocalRandom").create();
        RandomGenerator secureRandom = RandomGeneratorFactory.of("SecureRandom").create();
        RandomGenerator splittableRandom = RandomGeneratorFactory.of("SplittableRandom").create();
        RandomGenerator xoroshiro128PlusPlus = RandomGeneratorFactory.of("Xoroshiro128PlusPlus").create();
        RandomGenerator xoshiro256PlusPlus = RandomGeneratorFactory.of("Xoshiro256PlusPlus").create();
        RandomGenerator l64X256MixRandom = RandomGeneratorFactory.of("L64X256MixRandom").create();
        RandomGenerator l64X128StarStarRandom = RandomGeneratorFactory.of("L64X128StarStarRandom").create();
        RandomGenerator l64X128MixRandom = RandomGeneratorFactory.of("L64X128MixRandom").create();
        RandomGenerator l64X1024MixRandom = RandomGeneratorFactory.of("L64X1024MixRandom").create();
        RandomGenerator l32X64MixRandom = RandomGeneratorFactory.of("L32X64MixRandom").create();
        RandomGenerator l128X256MixRandom = RandomGeneratorFactory.of("L128X256MixRandom").create();
        RandomGenerator l128X128MixRandom = RandomGeneratorFactory.of("L128X128MixRandom").create();
        RandomGenerator l128X1024MixRandom = RandomGeneratorFactory.of("L128X1024MixRandom").create();

//        for (int i = 0; i < 5; i++) {
//            System.out.println(random.nextInt() + ";" +
//                    secureRandom.nextInt() + ";" +
//                    splittableRandom.nextInt() + ";" +
//                    xoroshiro128PlusPlus.nextInt() + ";" +
//                    xoshiro256PlusPlus.nextInt() + ";" +
//                    l64X256MixRandom.nextInt() + ";" +
//                    l64X128StarStarRandom.nextInt() + ";" +
//                    l64X128MixRandom.nextInt() + ";" +
//                    l64X1024MixRandom.nextInt() + ";" +
//                    l32X64MixRandom.nextInt() + ";" +
//                    l128X256MixRandom.nextInt() + ";" +
//                    l128X128MixRandom.nextInt() + ";" +
//                    l128X1024MixRandom.nextInt());
//        }

        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(0, 52) + ";" +
                    secureRandom.nextInt(0, 52) + ";" +
                    splittableRandom.nextInt(0, 52) + ";" +
                    xoroshiro128PlusPlus.nextInt(0, 52) + ";" +
                    xoshiro256PlusPlus.nextInt(0, 52) + ";" +
                    l64X256MixRandom.nextInt(0, 52) + ";" +
                    l64X128StarStarRandom.nextInt(0, 52) + ";" +
                    l64X128MixRandom.nextInt(0, 52) + ";" +
                    l64X1024MixRandom.nextInt(0, 52) + ";" +
                    l32X64MixRandom.nextInt(0, 52) + ";" +
                    l128X256MixRandom.nextInt(0, 52) + ";" +
                    l128X128MixRandom.nextInt(0, 52) + ";" +
                    l128X1024MixRandom.nextInt(0, 52));
        }


        RandomGeneratorFactory.all()
                .map(fac -> fac.group() + ":" + fac.name()
                        + " {"
                        + (fac.isSplittable() ? " 可拆分" : "")
                        + (fac.isStreamable() ? " 可流式传输" : "")
                        + (fac.isJumpable() ? " 可跳跃" : "")
                        + (fac.isLeapable() ? " 可跳跃且很远" : "")
                        + (fac.isHardware() ? " 硬件支持" : "")
                        + (fac.isStatistical() ? " 算法计算且有统计确定性" : "")
                        + (fac.isStochastic() ? " 使用外部或熵源作为输入计算随机生成器" : "")
                        + " stateBits: " + fac.stateBits()
//                        + " period: " + fac.period()
                        + " }"
                )
                .sorted().forEach(System.out::println);

    }
}
