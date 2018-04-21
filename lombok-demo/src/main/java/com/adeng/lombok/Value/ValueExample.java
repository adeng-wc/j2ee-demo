package com.adeng.lombok.Value;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.Wither;

/**
 *
 * @Value对于以下内容来说是简写：
 * final
 * @ToString
 * @EqualsAndHashCode
 * @AllArgsConstructor
 * @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
 * @Getter
 *
 * @author
 * @create 2018-04-21 23:19
 */
@Value
public class ValueExample {
    String name;
    @Wither(AccessLevel.PACKAGE)
    @NonFinal
    int age;
    double score;
    protected String[] tags;

    @ToString(includeFieldNames = true)
    @Value(staticConstructor = "of")
    public static class Exercise<T> {
        String name;
        T value;
    }
}
