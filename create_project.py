import os

def create_project_structure():
    # Базова директорія проєкту
    base_dir = 'HW11'

    # Шляхи для основних папок
    main_java_dir = os.path.join(base_dir, 'src', 'main', 'java', 'org', 'example')
    test_java_dir = os.path.join(base_dir, 'src', 'test', 'java')
    resources_dir = os.path.join(base_dir, 'src', 'main', 'resources')

    # Створення директорій
    os.makedirs(main_java_dir, exist_ok=True)
    os.makedirs(test_java_dir, exist_ok=True)
    os.makedirs(resources_dir, exist_ok=True)

    # Створення базових файлів
    with open(os.path.join(base_dir, '.gitignore'), 'w') as gitignore:
        gitignore.write("target/\n*.class\n*.log\n.idea/\n*.iml\n.DS_Store\n")

    with open(os.path.join(base_dir, 'pom.xml'), 'w') as pom:
        pom.write("""<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>HW11</artifactId>
    <version>1.0-SNAPSHOT</version>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>""")

    with open(os.path.join(main_java_dir, 'Main.java'), 'w') as main_java:
        main_java.write("""package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}""")

    print(f"Проєкт створено у директорії: {base_dir}")

# Виклик функції
create_project_structure()
