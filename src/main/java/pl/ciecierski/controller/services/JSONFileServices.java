package pl.ciecierski.controller.services;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.ciecierski.model.MazeModel;

import java.io.*;

public class JSONFileServices {

public Integer mazeQuantity=0;
    MazeModel mazeModel;
    MazeGenerator mazeGenerator = new MazeGenerator();

    ObjectMapper mapper = new ObjectMapper();


    public void serializeJSONMaze(MazeModel mazeModel, String fileName) {

//        System.out.println(mazeModel.toString());

        try {
            mapper.writeValue(new FileOutputStream(fileName), mazeModel);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public MazeModel deserializeJSONMaze(String fileName) {


        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileName);
        try {
            mazeModel = objectMapper.readValue(file, MazeModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mazeQuantity++;
        System.out.println("deserialization no. "+mazeQuantity+" from JSON");


        return mazeModel;
    }


}
