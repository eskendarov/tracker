package ru.job4j.stream.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private static final Builder BUILDER = new Builder();

    public static EasyStream of(List<Integer> source) {
        return BUILDER.of(source);
    }

    public EasyStream map(Function<Integer, Integer> mapper) {
        return BUILDER.map(mapper);
    }

    public EasyStream filter(Predicate<Integer> predicate) {
        return BUILDER.filter(predicate);
    }

    public List<Integer> collect() {
        return BUILDER.collect();
    }

    public static class Builder {

        private List<Integer> source;
        private final EasyStream stream = new EasyStream();

        public EasyStream of(List<Integer> source) {
            this.source = source;
            return stream;
        }

        public EasyStream map(Function<Integer, Integer> mapper) {
            final List<Integer> dest = new ArrayList<>();
            source.forEach(integer -> dest.add(mapper.apply(integer)));
            source = dest;
            return stream;
        }

        public EasyStream filter(Predicate<Integer> predicate) {
            final List<Integer> dest = new ArrayList<>();
            source.forEach(integer -> {
                if (predicate.test(integer)) {
                    dest.add(integer);
                }
            });
            source = dest;
            return stream;
        }

        public List<Integer> collect() {
            return source;
        }
    }
}
