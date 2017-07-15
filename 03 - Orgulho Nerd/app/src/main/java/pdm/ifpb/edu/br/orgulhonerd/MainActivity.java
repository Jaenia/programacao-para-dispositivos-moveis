package pdm.ifpb.edu.br.orgulhonerd;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Saga> sagas = new ArrayList<Saga>();
    private ListView lvSagas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sagas.add(new Saga("Senhor dos Aneis", "Numa terra fantástica e única, chamada Terra-Média, um hobbit (seres de estatura entre 80 cm e 1,20 m, com pés peludos e bochechas um pouco avermelhadas) recebe de presente de seu tio o Um Anel, um anel mágico e maligno que precisa ser destruído antes que caia nas mãos do mal. Para isso o hobbit Frodo (Elijah Woods) terá um caminho árduo pela frente, onde encontrará perigo, medo e personagens bizarros. Ao seu lado para o cumprimento desta jornada aos poucos ele poderá contar com outros hobbits, um elfo, um anão, dois humanos e um mago, totalizando 9 pessoas que formarão a Sociedade do Anel.", R.drawable.saga_senhordosaneis, (float) 4.5));
        this.sagas.add(new Saga("Star Wars", "Décadas após a queda de Darth Vader e do Império, surge uma nova ameaça: a Primeira Ordem, uma organização sombria que busca minar o poder da República e que tem Kylo Ren (Adam Driver), o General Hux (Domhnall Gleeson) e o Líder Supremo Snoke (Andy Serkis) como principais expoentes. Eles conseguem capturar Poe Dameron (Oscar Isaac), um dos principais pilotos da Resistência, que antes de ser preso envia através do pequeno robô BB-8 o mapa de onde vive o mitológico Luke Skywalker (Mark Hamill). Ao fugir pelo deserto, BB-8 encontra a jovem Rey (Daisy Ridley), que vive sozinha catando destroços de naves antigas. Paralelamente, Poe recebe a ajuda de Finn (John Boyega), um stormtrooper que decide abandonar o posto repentinamente. Juntos, eles escapam do domínio da Primeira Ordem.", R.drawable.saga_starwars, (float) 5.0));
        this.sagas.add(new Saga("Harry Potter", "Harry Potter (Daniel Radcliffe) é um garoto órfão de 10 anos que vive infeliz com seus tios, os Dursley. Até que, repentinamente, ele recebe uma carta contendo um convite para ingressar em Hogwarts, uma famosa escola especializada em formar jovens bruxos. Inicialmente Harry é impedido de ler a carta por seu tio Válter (Richard Griffiths), mas logo ele recebe a visita de Hagrid (Robbie Coltrane), o guarda-caça de Hogwarts, que chega em sua casa para levá-lo até a escola. A partir de então Harry passa a conhecer um mundo mágico que jamais imaginara, vivendo as mais diversas aventuras com seus mais novos amigos, Rony Weasley (Rupert Grint) e Hermione Granger (Emma Watson).", R.drawable.saga_harrypotter, (float) 4.0));
        this.sagas.add(new Saga("Doctor Who", "O Doutor é um Senhor do Tempo - um alien de um planeta distante chamado Gallifrey que tem dois corações e aproximadamente 900 anos. Em sua nave espacial, a TARDIS, ele atravessa as barreiras do espaço e do tempo lutando contra inimigos e criando aventuras com seus companheiros, que sempre escolhe para viajar junto a ele. Quando ele está prestes a morrer, ele se regenera e renasce em outro corpo inteiramente novo. ", R.drawable.saga_doctorwho,(float) 2.0));
        this.sagas.add(new Saga("Game of Thrones", "Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A irmandade da Patrulha da Noite busca proteger o reino de cada criatura que pode vir de lá da Muralha, mas já não tem os recursos necessários para garantir a segurança de todos. Depois de um verão de dez anos, um inverno rigoroso promete chegar com um futuro mais sombrio. Enquanto isso, conspirações e rivalidades correm no jogo político pela disputa do Trono de Ferro, o símbolo do poder absoluto.", R.drawable.saga_gameofthrones, (float) 2.0));
        this.sagas.add(new Saga("Universo Marvel", "Aventura sobre Carol Danvers, uma agente da CIA que tem contato com uma raça alienígena e ganha poderes sobre-humanos. Entre os seus poderes estão uma força fora do comum e a habilidade de voar.", R.drawable.saga_universomarvel, (float) 2.0));
        this.sagas.add(new Saga("Star Trek", "Desta vez, Kirk (Chris Pine), Spock (Zachary Quinto) e a tripulação da Enterprise encontram-se no terceiro ano da missão de exploração do espaço prevista para durar cinco anos. Eles recebem um pedido de socorro que acaba os ligando ao maléfico vilão Krall (Idris Elba), um insurgente anti-Frota Estelar interessado em um objeto de posse do líder da nave. A Enterprise é atacada, e eles acabam em um planeta desconhecido, onde o grupo acaba sendo dividido em duplas.", R.drawable.saga_startrek, (float) 2.0));
        this.sagas.add(new Saga("Universo DC", "O Universo DC é um ambiente fictício onde ocorrem a maioria das histórias publicadas pela DC Comics. Super Homem, Batman, Flash, Mulher Maravilha e Lanterna Verde são os super-heróis mais conhecidos deste universo.", R.drawable.saga_universodc, (float) 2.0));
        this.sagas.add(new Saga("Matrix", "Matrix é uma produção cinematográfica estadunidense e australiana de 1999, dos gêneros ação e ficção científica, dirigido pelas irmãs Wachowski e protagonizado por Keanu Reeves e Laurence Fishburne.", R.drawable.saga_matrix, (float) 2.0));
        this.sagas.add(new Saga("De Volta para o Futuro", "teste", R.drawable.saga_devoltaparaofuturo, (float) 2.0));
        this.sagas.add(new Saga("X-Men", "teste", R.drawable.saga_xmen, (float) 2.0));
        this.sagas.add(new Saga("Alien", "teste", R.drawable.saga_alien, (float) 2.0));
        this.sagas.add(new Saga("O Exterminador do Futuro", "teste", R.drawable.saga_oexterminadordofuturo, (float) 2.0));
        this.sagas.add(new Saga("Planeta dos Macacos", "teste", R.drawable.saga_planetadosmacacos, (float) 2.0));
        this.sagas.add(new Saga("Battlestar Galactica", "teste", R.drawable.saga_battlestar, (float) 2.0));

        lvSagas = (ListView) findViewById(R.id.lvSagas);

        //ArrayAdapter<Saga> adapter = new ArrayAdapter<Saga>(this, android.R.layout.simple_list_item_1, sagas);
        //lvSagas.setAdapter(adapter);

        SagaAdapter adapter = new SagaAdapter(MainActivity.this, MainActivity.this.sagas);
        lvSagas.setAdapter(adapter);

        lvSagas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, DetalhesActivity.class);
                it.putExtra("SAGA", MainActivity.this.sagas.get(position));

                startActivity(it);
            }
        });
    }
}
