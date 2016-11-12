package inm5001.rapidoservices;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.content.Intent;

        import inm5001.rapidoservices.utilisateur.Utilisateur;

/**
 * Created by joy-reybabagbeto on 16-10-24.
 */

public class ProfilActivity extends Activity {
    TextView nom = null;
    TextView prenom = null;
    TextView courriel = null;
    TextView telephone = null;
    Utilisateur u;
    Orchestrateur o;
    Button ajouter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        ajouter = (Button)findViewById(R.id.ajouter);
        Intent intent = getIntent();
        String prenom_Inscrip= intent.getStringExtra("prenom");
        String nom_Inscrip = intent.getStringExtra("nom");
        String courriel_Inscrip = intent.getStringExtra("email");
        String tel_Inscrip = intent.getStringExtra("email");
        final String userName = intent.getStringExtra("userName");
        String pass = intent.getStringExtra("password");



        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Orchestrateur o = new Orchestrateur();
                try {
                    u = o.recupererUtilisateur(userName);
                }catch(Exception e){
                    Utilisateur u = new Utilisateur();
                    System.out.println(e);
                }


                courriel = (TextView)findViewById(R.id.courrielProfil);
                telephone = (TextView)findViewById(R.id.telProfil);
                nom = (TextView)findViewById(R.id.nomProfil);
                prenom = (TextView)findViewById(R.id.prenomProfil);
                nom.setText(u.profile.nom);
                prenom.setText(u.profile.prenom);
                courriel.setText(u.profile.adresseCourriel);
                telephone.setText(u.profile.numeroTelephone);

            }
        });


                ajouter.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                // Le premier paramètre est le nom de l'activité actuelle
                // Le second est le nom de l'activité de destination



                    Intent ajouterService = new Intent(ProfilActivity.this, AjouterServiceActivity.class);


                    startActivity(ajouterService);






            }
        });
    }
}
