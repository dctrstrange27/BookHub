package com.example.jason_valley.front;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jason_valley.R;

import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.homeFragment.books;
import com.example.jason_valley.login.dialog;
import com.example.jason_valley.login.signup;
import com.example.jason_valley.usermodel.Books;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class front extends AppCompatActivity {

    TextInputEditText title, author, description, language,category ;
    ImageView picture;
    Button add;
    Bitmap bitmap;
    DataBase b = new DataBase(front.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.front);
       ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

//        add = findViewById(R.id.add);
          Boolean c =  b.checkBooks("Cleopatra");
         if(!c) addAdvetureBook();
          openLogin();
//         b.deleteBooks();
//        add = findViewById(R.id.login);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//              Toast.makeText(front.this,"Books Already Exist",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    //creating books
   public void addAdvetureBook(){
//       String aut = author.getText().toString();
//       String desc = description.getText().toString();
//       String lang = language.getText().toString();
//       String cat = category.getText().toString();
       //Adventure
       Books across_asia_on_a_bicycle = new Books(
               -1,"Across Asia on a Bicycle",
               "TThomas Gaskell Allen and William Lewis Sachtleben",
               "A fast moving narrative, interesting and full of twists of fate. Two young men take on the world in bygone times, when nations allowed such things. Riders of today will wonder at the challenge - but the same lure that drives cross-country cycling today is certainly in these pages.",
               "english",
               "adventure",
               "across",
               "across");
       Books journey = new Books(
               -1,"A Journey to the Centre of the Earth",
               "Jules Verne",
               "Journey to the Center of the Earth is a classic 1864 science fiction novel by Jules Verne. The story involves German professor Otto Lidenbrock who believes there are volcanic tubes going toward the centre of the Earth.",
               "english",
               "adventure",
               "journey",
               "journey");
       Books cleopatra= new Books(
               -1,
               "Cleopatra",
               " Miranda Kate ",
               "Cleopatra mixes historical action with supernatural events, and could be described as a historical fantasy novel",
               "english",
               "adventure",
               "cleopatra",
               "cleopatra");
       Books king_of_solomon = new Books(
               -1,
               "King Solomon's Mines",
               "H. Rider Haggard",
               "It tells of a search of an unexplored region of Africa by a group of adventurers led by Allan Quatermain for the missing brother of one of the party.",
               "english",
               "adventure",
               "king_solomon",
                "solomon");
       Books tarzan = new Books(
               -1,
               "Tarzan of the Apes",
               "Edgar Rice Burroughs",
               "This is the story of the ape-man Tarzan, raised in the wild by the great ape Kala, and how he learns the secrets of the jungle to survive—how to talk with the animals, swing through the trees, and fight the great predators.",
               "english",
               "adventure",
               "tarzan",
               "tarzan");
        //computer
       Books crack = new Books(
               -1,
               "Hacker Crackdown",
               "Bruce Sterling",
               "The Hacker Crackdown of 1990 was larger, better organized, more deliberate and more resolute than any previous effort in the brave new world of computer crime The U.S. Secret Service, private telephone security, and state and local law enforcement groups across the country all joined forces in a determined attempt to break the back of America’s electronic underground. It was a fascinating effort, with very mixed results",
               "English ",
               "Computer",
               "crackdown",
               "crackdown");
       Books heroes = new Books(
               -1,
               "Hackers Heroes of the Computer Revolution",
               "Steven Levy",
               "y Peter Samson was wandering around in Building 26 in the middle of the night is a matter that he would find difficult to explain. Some things are not spoken. If you were like the people whom Peter Samson was coming to know and befriend in this, his freshman year at the Massachusetts Institute of Technology in the winter of 1958-59, no explanation would be required",
                "English" ,
               " Computer",
               "hackers",
               "heroes");
       Books economy = new Books(
               -1,
               "Cleopatra",
               " Miranda Kate ",
               "Cleopatra mixes historical action with supernatural events, and could be described as a historical fantasy novel",
               "english",
               "adventure",
               "economy",
               "economy");
       Books coming = new Books(
               -1,
               "The Coming Technological Singularity",
               "Vernor Vinge",
               "The acceleration of technological progress has been the central feature of this century. I argue in this paper that we are on the edge of change comparable to the rise of human life on Earth. The precise cause of this change is the imminent creation by technology of entities with greater than human intelligence",
                "English",
               "Computer",
               "coming",
               "coming");
       Books jargon = new Books(
               -1,
               "The Hacker's Dictionary",
               "Eric S. Raymond and Guy L. Steele",
               "This is the Jargon File, a comprehensive compendium of hacker slang\n" + " illuminating many aspects of hackish tradition, folklore, and humor",
               "english",
               "Computer",
               "computer_jargon",
               "hackers");

       //Fiction
       Books alice = new Books(
               -1,
               "Alice's Adventures in Wonderland",
               "Lewis Caroll",
               "story about Alice who falls down a rabbit hole and lands into a fantasy world that is full of weird, wonderful people and animals. It is classic children's book that is also popular with adults",
               "English",
               "Fiction",
               "alice_adventure",
               "alice");
       Books sher = new Books(
               -1,
               "The Adventures of Sherlock Holmes",
               "Arthur Conan Doyle",
               "The movement of foreigners and money into and out of London are motifs that carry throughout Sherlock Holmes' adventures, as well as characters' strange and often unfortunate experiences when traveling abroad. Another motif and theme of the Holmes stories is opium use.",
               "English",
               "Fiction",
               "sherlocks",
               "sherlock");
       Books dracula = new Books(
               -1,
               "Dracula",
               "Bram Stoker",
               "His face was a strong, a very strong, aquiline, with high bridge of the thin nose and peculiarly arched nostrils, with lofty domed forehead, and hair growing scantily round the temples but profusely elsewhere.",
               "English ",
               "Fiction",
               "dracula",
               "dracula");
       Books fly = new Books(
               -1,
               "Fly Away Home",
               "Dave Cenker",
               "A father and daughter decide to attempt to lead a flock of orphaned Canada Geese south by air. Amy is only 13 years old when her mother is killed in a car accident in New Zealand. She goes to Canada to live with her father, Thomas, an eccentric inventor whom she barely knows",
               "English",
               "Fiction",
               "fly_away",
               "fly");
       Books les = new Books(
               -1,
               "Les Misérables",
               "Victor Hugo",
               "The story spans many years as it tells of Valjean's release from prison and reformation as an industrialist while being constantly pursued by the morally strict inspector Javert.",
               "English",
               "Fiction",
               "les_miserable",
               "les");
        //Horror
       Books beach = new Books(
               -1,
               "Beach Town Apocalypse",
               "Thomas Maxwell Harrison",
               "A mysterious disease has struck a hit and run victim. After Officer Dean begins the investigation it becomes clear the disease is the beginning of an epidemic. Harry and his family live a modest suburban life in Beach Town, on an island Southwest of the UK.",
               "English",
               "Horror",
               "beach_town",
               "beach");
       Books color = new Books(
               -1,
               "Color Out of Space",
               "H.P. Lovecraft",
               "In the tale, an unnamed narrator pieces together the story of an area known by the locals as the blasted heath in the hills west of the fictional town of Arkham, Massachusetts.",
               "English",
               "Horror",
               "color",
               "color");
       Books mostly = new Books(
               -1,
               "Mostly Dark",
               "Miranda Kate",
               "Mostly Dark waxes and wanes with thirty tales of darkness and light. An intriguing maelstrom of broken minds and broken hearts, from revenge to desire, from new found love to soulmates, herein lies a tale for everyone. Prepare your senses for an emotional and sometimes terrifying ride.",
               "English",
               "Horror",
               "mostly_dark",
               "mostly");
       Books invi = new Books(
               -1,
               "The Invisible Man",
               "H.G. Wells",
               "he story concerns the life and death of a scientist named Griffin who has gone mad. Having learned how to make himself invisible, Griffin begins to use his invisibility for nefarious purposes, including murder.",
               "English",
               "Horror",
               "invi",
               "invisible");
       Books raven = new Books(
               -1,
               "The Raven The Masque of the Red Death The Cask of Amontillado",
               "Edgar Allan Poe",
               "Is a short story by American writer Edgar Allan Poe, first published in 1842. The story follows Prince Prospero's attempts to avoid a dangerous plague, known as the Red Death, by hiding in his abbey.",
               "English",
               "Horror",
               "the_raven",
               "raven");

       //Horror
       Books irish = new Books(
               -1,
               "Irish Fairy Tales",
                "James Stephens",
               "Irish Fairy Tales is a retelling of ten Irish folktales by the Irish author James Stephens. The English illustrator Arthur Rackham provided interior artwork, including numerous black and white illustrations and sixteen color plates. The stories are set in a wooded, Medieval Ireland filled with larger-than-life hunters, warriors, kings, and fairies. Many stories concern the Fianna and their captain, Fionn mac Uail, from the Fenian Cycle of Irish mythology",
               "English",
               "Myth",
               "irish",
               "irish");
       Books arthur = new Books(
               -1,
               "King Arthur and His Knights",
               "Radford Warren",
               "Twenty-one stories from the Arthurian legends specially selected and adapted for children and told in simple well-written prose. The stirring tales of these chivalrous knights awaken the reader's admiration for courage and gentleness and high sense of honor essential in all ages.",
               "English",
               "Myth",
               "arthur",
               "arthur");
       Books myths = new Books(
               -1,
               "Myths and Legends of Ancient Greece and Rome",
               "E.M.Berens",
               "Before entering upon the many strange beliefs of the ancient Greeks, and the extraordinary number of gods they worshipped, we must first consider what kind of beings these divinities were.",
               "English",
               "Myth",
               "myths",
               "myths");
       Books nature = new Books(
               -1,
               "The Book of Nature Myths",
               "Florence Holbrook",
               "In preparing the Book of Nature Myths the desire has been to make a second reader which would be adapted to the child's interest, ability, and progress.The subject-matter is of permanent value, culled from the folk-lore of the primitive races; the vocabulary, based upon that of the Hiawatha Primer, isincreased gradually, and the new words and phrases will add to the child's powerof expression",
                "English",
               "Myth",
               "nature",
               "nature");
       Books science = new Books(
               -1,
               "The Science of Fairy Tales",
               "Edwin Sidney Hartland",
               "The art of story-telling has been cultivated in all ages and among all nations of which we have any record; it is the outcome of an instinct implanted universallyin the human mind.",
               "English",
               "Myth",
               "science",
               "science");


       Boolean i1 = b.createBooks(across_asia_on_a_bicycle);
       Boolean i2 = b.createBooks(journey);
       Boolean i3 = b.createBooks(cleopatra);
       Boolean i4 = b.createBooks(king_of_solomon);
       Boolean i5 = b.createBooks(tarzan);
       Boolean i6 = b.createBooks(crack);
       Boolean i7 = b.createBooks(heroes);
       Boolean i8 = b.createBooks(economy);
       Boolean i9 = b.createBooks(coming);
       Boolean i10 = b.createBooks(jargon);
       Boolean i11 = b.createBooks(alice);
       Boolean i12 = b.createBooks(dracula);
       Boolean i13 = b.createBooks(fly);
       Boolean i14 = b.createBooks(les);
       Boolean i15 = b.createBooks(beach);
       Boolean i16 = b.createBooks(color);
       Boolean i17 = b.createBooks(mostly);
       Boolean i18 = b.createBooks(mostly);
       Boolean i19 = b.createBooks(invi);
       Boolean i20 = b.createBooks(raven);
       Boolean i21 = b.createBooks(irish);
       Boolean i22 = b.createBooks(arthur);
       Boolean i23 = b.createBooks(myths);
       Boolean i24 = b.createBooks(nature);
       Boolean i25 = b.createBooks(science);





   }

    public void openLogin(){
        Button login =  findViewById(R.id.login);
        Button signup =  findViewById(R.id.signup);
        Intent goToLogin = new Intent(this, com.example.jason_valley.login.login.class);
        Intent goToSignup = new Intent(this, com.example.jason_valley.login.signup.class);
        //route
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToLogin);
            }});
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   startActivity(goToSignup);}});
    }

}