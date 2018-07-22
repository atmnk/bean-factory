package com.atmaram.beanfactory.generators;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapGeneratorTest {
    @Test
    public void should_return_empty_map_when_no_key_or_value_generator_defined(){
        MapGenerator<Integer,String> mapGenerator=new MapGenerator<>(10,20);
        Map<Integer,String> generatedMap= mapGenerator.generate();
        assertThat(generatedMap).isInstanceOf(Map.class);
        assertThat(generatedMap.size()).isEqualTo(0);

    }

    @Test
    public void should_return_map_with_certain_no_of_entries_when_no_range_defined(){
        MapGenerator<Integer,String> mapGenerator=new MapGenerator<>(new IntegerGenerator(),()->"World");
        Map<Integer,String> generatedMap= mapGenerator.generate();
        assertThat(generatedMap).isInstanceOf(Map.class);
        assertThat(generatedMap.size()).isBetween(0,10);
        if(generatedMap.size()>0){
            for (Integer key:
                 generatedMap.keySet()) {
                assertThat(generatedMap.get(key)).isEqualTo("World");

            }
        }

    }
    @Test
    public void should_return_map_with_certain_no_of_entries_when_max_range_defined(){
        MapGenerator<Integer,String> mapGenerator=new MapGenerator<>(5,new IntegerGenerator(),()->"World");
        Map<Integer,String> generatedMap= mapGenerator.generate();
        assertThat(generatedMap).isInstanceOf(Map.class);
        assertThat(generatedMap.size()).isBetween(0,5);
        if(generatedMap.size()>0){
            for (Integer key:
                    generatedMap.keySet()) {
                assertThat(generatedMap.get(key)).isEqualTo("World");

            }
        }

    }
    @Test
    public void should_return_map_with_certain_no_of_entries_when_both_range_defined(){
        MapGenerator<Integer,String> mapGenerator=new MapGenerator<>(4,5,new IntegerGenerator(),()->"World");
        Map<Integer,String> generatedMap= mapGenerator.generate();
        assertThat(generatedMap).isInstanceOf(Map.class);
        assertThat(generatedMap.size()).isBetween(4,5);
        if(generatedMap.size()>0){
            for (Integer key:
                    generatedMap.keySet()) {
                assertThat(generatedMap.get(key)).isEqualTo("World");

            }
        }

    }
}