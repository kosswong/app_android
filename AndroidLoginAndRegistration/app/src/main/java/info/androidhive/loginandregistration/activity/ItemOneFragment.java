package info.androidhive.loginandregistration.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.loginandregistration.R;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import info.androidhive.loginandregistration.R;

public class ItemOneFragment extends Fragment {

    private AppCompatActivity mClass;

    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.product_all, container, false);
        String json_string = "{\"title\":false,\"products\":[{\"pid\":\"1\",\"name\":\"Deadpool\",\"price\":\"1000\",\"description\":\"A fast-talking mercenary with a morbid sense of humor is subjected to a rogue experiment that leaves him with accelerated healing powers and a quest for revenge.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"2\",\"name\":\"Captain America: Civil War\",\"price\":\"1000\",\"description\":\"Political interference in the Avengers' activities causes a rift between former allies Captain America and Iron Man.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"3\",\"name\":\"Captain America: The Winter Soldier\",\"price\":\"1000\",\"description\":\"As Steve Rogers struggles to embrace his role in the modern world, he teams up with a fellow Avenger and S.H.I.E.L.D agent, Black Widow, to battle a new threat from history: an assassin known as the Winter Soldier.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"4\",\"name\":\"Jigsaw\",\"price\":\"1000\",\"description\":\"Bodies are turning up around the city, each having met a uniquely gruesome demise. As the investigation proceeds, evidence points to one suspect: John Kramer, the man known as Jigsaw, who has been dead for ten years.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"5\",\"name\":\"World War Z\",\"price\":\"1000\",\"description\":\"Former United Nations employee Gerry Lane traverses the world in a race against time to stop the Zombie pandemic that is toppling armies and governments, and threatening to destroy humanity itself.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"6\",\"name\":\"Salt\",\"price\":\"1000\",\"description\":\"A CIA agent goes on the run after a defector accuses her of being a Russian spy.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"7\",\"name\":\"Les Mis?rables\",\"price\":\"1000\",\"description\":\"In 19th-century France, Jean Valjean, who for decades has been hunted by the ruthless policeman Javert after breaking parole, agrees to care for a factory worker's daughter. The decision changes their lives forever.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"8\",\"name\":\"Happy Death Day\",\"price\":\"1000\",\"description\":\"A college student must relive the day of her murder over and over again, in a loop that will end only when she discovers her killer's identity.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"9\",\"name\":\"It: Chapter One\",\"price\":\"1000\",\"description\":\"A group of bullied kids band together when a shapeshifting monster, taking the appearance of a clown, begins hunting children.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"10\",\"name\":\"Wonder Woman\",\"price\":\"1000\",\"description\":\"When a pilot crashes and tells of conflict in the outside world, Diana, an Amazonian warrior in training, leaves home to fight a war, discovering her full powers and true destiny.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"11\",\"name\":\"Thor: Ragnarok\",\"price\":\"1000\",\"description\":\"Imprisoned, the almighty Thor finds himself in a lethal gladiatorial contest against the Hulk, his former ally. Thor must fight for survival and race against time to prevent the all-powerful Hela from destroying his home and the Asgardian civilization.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"12\",\"name\":\"Batman Begins\",\"price\":\"1000\",\"description\":\"After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from the corruption that Scarecrow and the League of Shadows have cast upon it.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"13\",\"name\":\"The Dark Knight\",\"price\":\"1000\",\"description\":\"When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham, the Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"14\",\"name\":\"The Dark Knight Rises\",\"price\":\"1000\",\"description\":\"Eight years after the Joker's reign of anarchy, the Dark Knight, with the help of the enigmatic Catwoman, is forced from his exile to save Gotham City, now on the edge of total annihilation, from the brutal guerrilla terrorist Bane.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"15\",\"name\":\"Suicide Squad\",\"price\":\"1000\",\"description\":\"A secret government agency recruits some of the most dangerous incarcerated super-villains to form a defensive task force. Their first mission: save the world from the apocalypse.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"16\",\"name\":\"Justice League\",\"price\":\"1000\",\"description\":\"Fueled by his restored faith in humanity and inspired by Superman's selfless act, Bruce Wayne enlists the help of his newfound ally, Diana Prince, to face an even greater enemy.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"17\",\"name\":\"Kingsman: The Secret Service\",\"price\":\"1000\",\"description\":\"A spy organization recruits an unrefined, but promising street kid into the agency's ultra-competitive training program, just as a global threat emerges from a twisted tech genius.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"18\",\"name\":\"Kingsman: The Golden Circle\",\"price\":\"1000\",\"description\":\"When their headquarters are destroyed and the world is held hostage, the Kingsman's journey leads them to the discovery of an allied spy organization in the US. These two elite secret organizations must band together to defeat a common enemy.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"19\",\"name\":\"Doctor Strange\",\"price\":\"1000\",\"description\":\"While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"20\",\"name\":\"Iron Man\",\"price\":\"1000\",\"description\":\"After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"21\",\"name\":\"Iron Man 2\",\"price\":\"1000\",\"description\":\"With the world now aware of his identity as Iron Man, Tony Stark must contend with both his declining health and a vengeful mad man with ties to his father's legacy.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"22\",\"name\":\"Iron Man 3\",\"price\":\"1000\",\"description\":\"When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"23\",\"name\":\"Inception\",\"price\":\"1000\",\"description\":\"A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"24\",\"name\":\"Fifty Shades of Grey\",\"price\":\"1000\",\"description\":\"Literature student Anastasia Steele's life changes forever when she meets handsome, yet tormented, billionaire Christian Grey.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"25\",\"name\":\"Fifty Shades Darker\",\"price\":\"1000\",\"description\":\"While Christian wrestles with his inner demons, Anastasia must confront the anger and envy of the women who came before her.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"26\",\"name\":\"Taken\",\"price\":\"1000\",\"description\":\"A retired CIA agent travels across Europe and relies on his old skills to save his estranged daughter, who has been kidnapped while on a trip to Paris.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"27\",\"name\":\"Taken 2\",\"price\":\"1000\",\"description\":\"In Istanbul, retired CIA operative Bryan Mills and his wife are taken hostage by the father of a kidnapper Mills killed while rescuing his daughter.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"28\",\"name\":\"Taken 3\",\"price\":\"1000\",\"description\":\"Ex-government operative Bryan Mills is accused of a ruthless murder he never committed or witnessed. As he is tracked and pursued, Mills brings out his particular set of skills to find the true killer and clear his name.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"29\",\"name\":\"American Sniper\",\"price\":\"1000\",\"description\":\"Navy S.E.A.L. sniper Chris Kyle's pinpoint accuracy saves countless lives on the battlefield and turns him into a legend. Back home to his wife and kids after four tours of duty, however, Chris finds that it is the war he can't leave behind.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"30\",\"name\":\"Ant-Man\",\"price\":\"1000\",\"description\":\"Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help his mentor, Dr. Hank Pym, plan and pull off a heist that will save the world.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"31\",\"name\":\"Avengers: Age of Ultron\",\"price\":\"1000\",\"description\":\"When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"32\",\"name\":\"Coco\",\"price\":\"1000\",\"description\":\"Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to work out the mystery.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"33\",\"name\":\"Olaf's Frozen Adventure?\",\"price\":\"1000\",\"description\":\"A Christmas-themed special featuring characters from Walt Disney Pictures' 53rd full-length animated motion picture, Frozen (2013).\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"34\",\"name\":\"Cinderella\",\"price\":\"1000\",\"description\":\"When her father unexpectedly passes away, young Ella finds herself at the mercy of her cruel stepmother and her scheming step-sisters. Never one to give up hope, Ella's fortunes begin to change after meeting a dashing stranger.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"35\",\"name\":\"Up\",\"price\":\"1000\",\"description\":\"Seventy-eight year old Carl Fredricksen travels to Paradise Falls in his home equipped with balloons, inadvertently taking a young stowaway.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"36\",\"name\":\"The Fast and the Furious\",\"price\":\"1000\",\"description\":\"Los Angeles police officer Brian O'Connor must decide where his loyalty really lies when he becomes enamored with the street racing world he has been sent undercover to destroy.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"37\",\"name\":\"The Fast and the Furious: Tokyo Drift\",\"price\":\"1000\",\"description\":\"A teenager becomes a major competitor in the world of drift racing after moving in with his father in Tokyo to avoid a jail sentence in America.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"38\",\"name\":\"Fast & Furious 6\",\"price\":\"1000\",\"description\":\"Hobbs has Dominic and Brian reassemble their crew to take down a team of mercenaries: Dominic unexpectedly gets convoluted also facing his presumed deceased girlfriend, Letty.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"39\",\"name\":\"Furious 7\",\"price\":\"1000\",\"description\":\"Deckard Shaw seeks revenge against Dominic Toretto and his family for his comatose brother.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"},{\"pid\":\"40\",\"name\":\"The Fate of the Furious\",\"price\":\"1000\",\"description\":\"When a mysterious woman seduces Dom into the world of terrorism and a betrayal of those closest to him, the crew face trials that will test them as never before.\",\"created_at\":\"NULL\",\"updated_at\":\"NULL\"}],\"success\":1}";

        try {

            ListView listView = (ListView) rootView.findViewById(R.id.list_view);

            List<String> items = new ArrayList<>();
            JSONObject root = new JSONObject(json_string);

            JSONArray array= root.getJSONArray("products");

            for(int i=0;i<array.length();i++)
            {
                JSONObject object= array.getJSONObject(i);
                items.add(object.getString("name"));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);

            if (listView != null) {
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(getContext(),
                                "Please enter the credentials!"+position, Toast.LENGTH_LONG)
                                .show();
                        Intent myIntent = new Intent(getActivity(), MovieDetailActivity.class);
                        myIntent.putExtra("Id", position);
                        startActivity(myIntent);
                    }
                });
            }

            JSONObject nested= root.getJSONObject("nested");
            Log.d("TAG","flag value "+nested.getBoolean("flag"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rootView;
    }
}