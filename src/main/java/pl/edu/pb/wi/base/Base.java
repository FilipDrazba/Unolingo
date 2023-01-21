package pl.edu.pb.wi.base;

import pl.edu.pb.wi.model.IterableCollection;


import java.io.File;
import java.util.*;

public class Base implements IterableCollection<String> {
    //TODO: Sprawdzić Singleton
    private static Base instance = null;
    private final HashMap<String, Collection<String>> closedQuestionsCollection;
    private final HashMap<String, Collection<String>> openQuestionRecordsCollection;

    private Base() {
        closedQuestionsCollection = new HashMap<>();
        openQuestionRecordsCollection = new HashMap<>();
    }

    protected static Base getInstance() {
        if (instance == null)
            instance = new Base();
        return instance;
    }

    public Iterator<String> createOpenQuestionRecordIterator(String key) {
        if (!openQuestionRecordsCollection.containsKey(key)) {
            Collection<String> collection=new TreeSet<>();
            openQuestionRecordsCollection.put(key, collection);
            try {
                try (Scanner scanner = new Scanner(new File(key + ".csv"))) {
                    while (scanner.hasNext())
                        collection.add(scanner.nextLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return openQuestionRecordsCollection.get(key).iterator();
    }


    public Iterator<String> createClosedQuestionRecordIterator(String key) {
        if (!closedQuestionsCollection.containsKey(key)) {
            Collection<String> collection=new TreeSet<>();
            closedQuestionsCollection.put(key, collection);
            try {
                try (Scanner scanner = new Scanner(new File(key + ".csv"))) {
                    while (scanner.hasNext())
                        collection.add(scanner.nextLine());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return closedQuestionsCollection.get(key).iterator();
    }

    @Override
    public Iterator<String> createIterator(String key) {


        if(key.startsWith("1")){
            return createClosedQuestionRecordIterator(key);
        }else{
            return createOpenQuestionRecordIterator(key);
        }
    }
}
