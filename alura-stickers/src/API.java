public enum API {

    IMDB_Top_Movies("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB()),
    Nasa("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new ExtratorDeCounteudoDaNasa()),
    Linguagens("http://localhost:8080/linguagens", new ExtratorDeConteudoDasLinguagens());

    private String url;
    private ExtratorDeConteudo extrator;
    
    private API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }

}
