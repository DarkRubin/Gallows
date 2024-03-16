public record Picture() {
    private static final String start = """
                __________
                |/       |
                |
                |
                |
                |
                |
                ----------
                """;
    private static final String error1 = """
                __________
                |/       |
                |       (_)
                |
                |
                |
                |
                ----------
                """;
    private static final String error2 = """
                __________
                |/       |
                |       (_)
                |        |
                |        |
                |
                |
                ----------
                """;
    private static final String error3 = """
                __________
                |/       |
                |       (_)
                |      / |
                |        |
                |
                |
                ----------
                """;
    private static final String error4 = """
                __________
                |/       |
                |       (_)
                |      / | \\
                |        |
                |
                |
                ----------
                """;
    private static final String error5 = """
                __________
                |/       |
                |       (_)
                |      / | \\
                |        |
                |       /
                |
                ----------
                """;
    private static final String error6 = """
                __________
                |/       |
                |       (_)
                |      / | \\
                |        |
                |       / \\
                |
                ----------
                """;
    private static final String[] pictures = {start, error1, error2, error3, error4, error5, error6};

    public static void printPicture(int errors) {
        System.out.println(pictures[errors]);
    }
}
