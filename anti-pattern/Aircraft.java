public class Aircraft {
    private String type;
    private String color;

    public Aircraft(String type) {
        this.type = type;
    }

    public Aircraft(String type, String color) {
        this.type = type;
        this.color = color;
    }
}

/*
If you continue this way you'll end up having a bunch of constructors with increasing number of arguments looking like a telescope:

Aircraft(String type)
Aircraft(String type, String color)
Aircraft(String type, String color, String prop3)
Aircraft(String type, String color, String prop3, String prop4)
 */

/*
The telescoping pattern is called an anti-pattern: how NOT to do things!
The way to approach a class with an increasing number of variables is to use the Builder Pattern
 */
