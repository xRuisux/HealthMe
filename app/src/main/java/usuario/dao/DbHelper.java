package usuario.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    protected static final String NOME_DB = "banco.db";
    protected static final int VERSAO = 3;
    private SqlScripts scripts = new SqlScripts();

    // TABELA DOS USUARIOS
    protected static final String TABELA_USUARIO = "tabela_usuarios";
    protected static final String ID_USUARIO = "_id_usuario";
    protected static final String USER = "user";
    protected static final String PASSWORD = "password";

    // TABELA DAS PESSOAS
    protected static final String TABELA_PESSOA = "tabela_pessoas";
    protected static final String ID_PESSOA ="_id_pessoa";
    protected static final String NOME = "nome";
    protected static final String PESSOA_USER = "pessoa_usuario";
    protected static final String ENDERECO_CASA = "endereco_casa";
    protected static final String ENDERECO_TRABALHO = "endereco_trabalho";
    protected static final String PLANO_SAUDE = "plano_saude";
    protected static final String NASCIMENTO = "nascimento";

    //TABELA DOS EVENTOS
    public static final String TABELA_EVENTO = "tabela_evento";
    public static final String ID_EVENTO = "_id_evento";
    public static final String EVENTO_NOME = "evento_nome";
    public static final String USUARIO_EVENTO = "evento_usuario";
    public static final String DESCRICAO = "descricao";
    public static final String DATA = "data";

    //TABELA CONTATOS
    public static final String TABELA_CONTATO = "tabela_contato";
    protected static final String ID_CONTATO = "contato_emergencia1";
    protected static final String CONTATO_NOME = "contato_nome";
    protected static final String CONTATO_TELEFONE = "contato_telefone";
    protected static final String USUARIO_CONTATO = "contato_usuario";

    public DbHelper(Context context){
        super(context, NOME_DB,null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scripts.createTabelaUsuario());
        db.execSQL(scripts.createTabelaPessoa());
        db.execSQL(scripts.createTabelaEvento());
        db.execSQL(scripts.createTabelaContato());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_PESSOA);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_EVENTO);
        db.execSQL("DROP TABLE IF EXISTS "+ TABELA_CONTATO);

        onCreate(db);
    }
}
