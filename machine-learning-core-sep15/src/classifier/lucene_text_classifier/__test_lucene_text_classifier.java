package classifier.lucene_text_classifier;

import java.io.File;
import java.util.List;


public class __test_lucene_text_classifier {
	public static void main(String[] args) throws Exception {
		String filePath = "/Users/phamdinhthang/Desktop/Datasets/20_newsgroups";
		File news_group = new File(filePath);
		List<News> news = News.scanNews(news_group);
		LuceneTextClassifier cl = new LuceneTextClassifier();
		cl.train(news);
		
		News test = news.get(10);
		Object predicted = cl.classify(test);
		System.out.println("Single test: Label = " + test.getLabel() + ", predicted = " + predicted);
		cl.crossValidation(5, true);
	}
}
