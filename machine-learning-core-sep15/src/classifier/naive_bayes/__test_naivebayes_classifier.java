package classifier.naive_bayes;

import java.util.ArrayList;
import java.util.List;

import data.util.CSVUtil;
import data.util.FileDownloader;

public class __test_naivebayes_classifier {
	public static void main(String[] args) throws Exception {
		String src = "https://www.dropbox.com/s/23q56pn8mwpgmuz/iris.csv?dl=1";
		List<String[]> iris_data = CSVUtil.readCSV(FileDownloader.fileFromUrl(src));
		iris_data.remove(0);//Skip header
		
		List<NaiveBayesData> train = new ArrayList<NaiveBayesData>();
		for (String[] line:iris_data) {
			NaiveBayesData dk = new NaiveBayesData();
			for (int i=0;i<line.length-1;i++) dk.features.add(new Double(Double.parseDouble(line[i])));
			if (line[line.length-1].equals("setosa")) dk.label = new Integer(1);
			if (line[line.length-1].equals("versicolor")) dk.label = new Integer(2);
			if (line[line.length-1].equals("virginica")) dk.label = new Integer(3);
			train.add(dk);
		}
		
		
		NaiveBayesClassifier cl = new NaiveBayesClassifier(train);
		cl.classify(train.get(10));	
		cl.classify(train.get(50));
		cl.classify(train.get(80));
	}
}
