public class Book implements Comparable<Book> {
    private String title;
    private String Author;
    private String BType;
    private int year;
    private double rating; // out of 5
    int checkOut = 0;

    @Override
    public int compareTo(Book b) {
        return title.compareTo(b.title);
    }

    // These are only allowed values for BookType
   enum BookTypes  { FICTION, NONFICTION, REFERENCE };

    public Book(String title, String author, String BookType, int year, double rating ) {
        this.title = title;
        // Don't need 'this' if no confusion between param name
        Author = author;
        BType = BookType;
        this.rating = rating;
        this.year = year;
        if ( !checkBookTypes( ) ) {
            System.out.printf("\n Error Cannot set bookType to %s", BType);
            throw new IllegalArgumentException("BookType:" + BType + " Not Valid");
        }
        this.checkOut = setCheckOutTime();
    }

    private int setCheckOutTime( ) {
        if ( BType.toUpperCase().equals("FICTION")){
            return 30;
        } else if ( BType.toUpperCase().equals("NONFICTION")) {
            return 20;
        } else {
            return 0;
        }
    }
    private boolean checkBookTypes() {
        for( BookTypes bookType : BookTypes.values()){
           if ( bookType.toString().equals(BType.toUpperCase())){
               return true;
            }
        }
        return false;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        Author = author;
    }
    public String getBType() {
        return BType;
    }
    public void setBType(String BType) {
        this.BType = BType;
    }
    public int getCheckOut() {
        return this.checkOut;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", Author='" + Author + '\'' +
                ", BType='" + BType + '\'' +
                ", checkOut=" + checkOut +
                '}';
    }
}