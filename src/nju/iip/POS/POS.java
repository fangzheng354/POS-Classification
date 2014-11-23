package nju.iip.POS;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class POS{
	
	
	public static ArrayList<String>getTaggedWord(ArrayList<String>words){
		ArrayList<String>tagged_word=new ArrayList<String>();
		String content="";
		for(String word:words){
			content=content+word+" ";
		}
		MaxentTagger tagger = new MaxentTagger("models/chinese-distsim.tagger");
		List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(content)));
		for (List<HasWord> sentence : sentences) {
			ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
			for(TaggedWord word:tSentence){
				tagged_word.add(word.toString());
			}
		}
		return tagged_word;
		
	}
	
	
	public static void main(String[] args) throws Exception {
	    MaxentTagger tagger = new MaxentTagger("models/chinese-distsim.tagger");
	    String content = " ";  
	    List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new BufferedReader(new StringReader(content)));  
	    for (List<HasWord> sentence : sentences) {
	        ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
	        System.out.println(tSentence.size());
	      }
	  }

}
