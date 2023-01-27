package expression.parser;


public final class Json {
    public static Object parse(final String string) {
        return parse(new StringCharSource(string));
    }

    public static Object parse(CharSource source) {
        return new JsonParser(source).parse();
    }

    protected static class JsonParser extends BaseParser {

        public JsonParser(CharSource source) {
            super(source);
        }

        public Object parse() {
            skipWhiteSpace();
            final Object result = parseValue();
            skipWhiteSpace();
            if (!end()) {
                throw error("Expected");
            }
            return result;
        }

        public void skipWhiteSpace() {
            do {
            } while (take(' '));
        }

        private Object parseValue() {
            if (take('"')) {
                return parseString();

            } else if (take('t')) {
                expect("rue");
                return true;
            } else {
                throw error("proebali");
            }
        }

        protected String parseString() {
            StringBuilder result = new StringBuilder();
            while (!take('"')) {
                result.append(take());
            }
            return result.toString();
        }

    }
}
