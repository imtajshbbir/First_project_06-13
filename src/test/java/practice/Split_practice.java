package practice;

public class Split_practice
{
    public static void main(String[] args) {
        String rawdata = "Google was founded in September 1998 by Larry Page and Sergey Brin while they were Ph.D. students at Stanford University in California. Together they own about 14 percent of its shares and control 56 percent of the stockholder voting power through supervoting stock." +
                " They incorporated Google as a California privately held company on September 4, 1998, in California." +
                " Google was then reincorporated in Delaware on October 22, 2002.[13] An initial public offering (IPO) took place on August 19, 2004, and Google moved to its headquarters in Mountain View, California, nicknamed the Googleplex." +
                " In August 2015, Google announced plans to reorganize its various interests as a conglomerate called Alphabet Inc." +
                " Google is Alphabet's leading subsidiary and will continue to be the umbrella company for Alphabet's Internet interests." +
                " Sundar Pichai was appointed CEO of Google, replacing Larry Page who became the CEO of Alphabet.";
        String sentences[] = rawdata.split("\\.");
        System.out.println("what is the size of sentence " + rawdata.split("\\. ").length);
        for(int i =0; i<sentences.length; i++)
        {
            System.out.println("the result is " +sentences[i]);
        }
        String word[] = sentences[2].split(" ");
        for(int i=0; i<word.length;i++)
        {
            if (word[i].length() != 0)

            {
                System.out.println("size of word " + word[i].length());
            System.out.println("Print the words " + word[i]);
            }
        }
    }


}
