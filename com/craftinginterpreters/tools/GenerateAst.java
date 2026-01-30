package com.craftinginterpreters.tools;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.io.PrintWriter;

public class GenerateAst {
    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.err.println("Usage: generate_ast <output_directory>");
        }
        String outputDir = args[0];
        defineAst(outputDir, "Expr", Arrays.asList(
      "Binary   : Expr left, Token operator, Expr right",
            "Grouping : Expr expression",
            "Literal  : Object value",
            "Unary    : Token operator, Expr right"
        ));
    }

    static void defineAst(String outputDir, String baseName, List<String> types) throws IOException {
        String path = outputDir + "/" + baseName + ".java";
        PrintWriter writer = new PrintWriter(path, "UTF-8");

        writer.println("import com.craftinginterpreters.lox");
        writer.println();
        writer.println("import java.util.List;");
        writer.println("abstract class " + baseName + "{");

        for(String type : types) {
            String className = type.split(":")[0].trim();
            String fields = type.split(":")[1].trim();
            defineType(writer, baseName, className, fields);
        }


        writer.println("}");
        writer.close();
    }

    static void defineType(PrintWriter writer, String baseName, String className, String fieldList){
        writer.println("static class " + className + "extends" + baseName + " {");
        writer.println(className + "(" + fieldList + ") {");

        String[] fields = fieldList.split(",");
        for(String field : fields) {
            String name = field.split(" ")[1];
            writer.println(" this." + name + " = " + name + ";");
        }

        writer.println("}");
        
        writer.println();

        for(String field : fields){
            writer.println("final " + field + ";");

        }
        writer.println("}");

    }

}

