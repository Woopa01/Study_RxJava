import com.sun.tools.javac.util.Pair;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

public class Pattern {
    public static void main(String[] args) {

        // filter-map-reduce 패턴
        List<Pair<String,Integer>> sales = new ArrayList<>();

        sales.add(new Pair<>("Tv",2500));
        sales.add(new Pair<>("Camera",300));
        sales.add(new Pair<>("Tv",1600));
        sales.add(new Pair<>("Phone",800));

        Maybe<Integer> tvSales = Observable.fromIterable(sales)
                .filter(sale -> "Tv".equals(sale.fst))
                .map(sale -> sale.snd)
                .reduce((sale1 , sale2) -> sale1 + sale2);

        tvSales.subscribe(tot -> System.out.println("Tv Sales : $" + tot));


    }
}
