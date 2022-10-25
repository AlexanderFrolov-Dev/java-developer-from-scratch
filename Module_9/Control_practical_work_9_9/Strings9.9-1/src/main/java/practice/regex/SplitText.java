package practice.regex;

public class SplitText {

    public static void main(String[] args) {
        String text = "JavaScript (JS) is a lightweight, interpreted, or just-in-time compiled programming language with first-class functions. While it is most well-known as the scripting language for Web pages, many non-browser environments also use it, such as Node.js, Apache CouchDB and Adobe Acrobat. JavaScript is a prototype-based, multi-paradigm, single-threaded, dynamic language, supporting object-oriented, imperative, and declarative (e.g. functional programming) styles. Read more about JavaScript.\n" +
                "\n" +
                "This section is dedicated to the JavaScript language itself, and not the parts that are specific to Web pages or other host environments. For information about APIs that are specific to Web pages, please see Web APIs and DOM.\n" +
                "\n" +
                "The standards for JavaScript are the ECMAScript Language Specification (ECMA-262) and the ECMAScript Internationalization API specification (ECMA-402). As soon as one browser implements a feature, we try to document it. This means that cases where some proposals for new ECMAScript features have already been implemented in browsers, documentation and examples in MDN articles may use some of those new features. Most of the time, this happens between the stages 3 and 4, and is usually before the spec is officially published.";

        System.out.println(splitTextIntoWords(text));
    }

    public static String splitTextIntoWords(String text) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.split("[^a-zA-Z]+");

        for (String word : words) {
            sb.append(word).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}