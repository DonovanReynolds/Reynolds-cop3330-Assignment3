package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WebsiteGen {

    String siteName;
    String authorName;
    String URL;
    boolean javaScriptFolder;
    boolean CSSFolder;

    public WebsiteGen() {
    }

    public WebsiteGen(String siteName, String authorName, boolean javaScriptFolder, boolean CSSFolder) {
        this.siteName = siteName;
        this.authorName = authorName;
        URL = makeDir();
        System.out.println(URL);
        this.javaScriptFolder = javaScriptFolder;
        this.CSSFolder = CSSFolder;
    }

    public void makeFolders() throws IOException {
        makeIndex();
        if(javaScriptFolder)
            makeJS();
        if(CSSFolder)
            makeCSS();

        indexWrite();
    }

    private String makeDir()
    {
        File dir = new File("input/ex43/website");
        if(dir.isDirectory())
            return dir.toString();
        if (dir.mkdir())
        {
            System.out.println(dir.toString());
            return dir.toString();
        }

        return "";
    }

    private void makeIndex() throws IOException {
        File index = new File(URL + "/index.html");
         if(index.createNewFile())
             System.out.println("Created " + index.toString());
         else
         {
             if (index.delete())
                makeIndex();

         }

    }

    private void makeJS() throws IOException {
        File js = new File(URL + "/js/");
        if(js.mkdir())
            System.out.println("Created " + js.toString());
    }

    private void makeCSS() throws IOException{
        File css = new File(URL + "/css/");
        if(css.mkdir())
            System.out.println("Created " + css.toString());
    }

    public String generateIndexContent(String title, String author)
    {

        return "<!DOCTYPE html>\n\n<html>\n\t<head>\n" +
                "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" author =\""+author+"\">\n" +
                "\t\t<title>" + title + "</title>\n" +
                "\t</head>\n\t<body>\n" +
                "\t\t<p>\n\t\t\t<----Replace with something useful---->\n\t\t</p>\n" +
                "\t</body>\n</html>";
    }

    private void indexWrite() throws IOException {
        FileWriter temp = new FileWriter(URL+ "/index.html");
        temp.write(generateIndexContent(siteName,authorName));
        temp.close();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public boolean isJavaScriptFolder() {
        return javaScriptFolder;
    }

    public void setJavaScriptFolder(boolean javaScriptFolder) {
        this.javaScriptFolder = javaScriptFolder;
    }

    public boolean isCSSFolder() {
        return CSSFolder;
    }

    public void setCSSFolder(boolean CSSFolder) {
        this.CSSFolder = CSSFolder;
    }

    @Override
    public String toString() {
        return URL;
    }
}
