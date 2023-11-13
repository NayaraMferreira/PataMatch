import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PataMatchapp extends Application {

    private ObservableList<String> perfisList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("PataMatch");

        // Criar controles
        Label labelNome = new Label("Nome:");
        TextField textFieldNome = new TextField();

        Label labelIdade = new Label("Idade:");
        Spinner<Integer> spinnerIdade = new Spinner<>(0.0, 20, 40);

        Label labelTemperamento = new Label("Temperamento:");
        TextField textFieldTemperamento = new TextField();

        Label labelHistoria = new Label("História:");
        TextArea textAreaHistoria = new TextArea();

        Button buttonCriarPerfil = new Button("Criar Perfil");

        ListView<String> listViewPerfis = new ListView<>(perfisList);
        listViewPerfis.setPrefWidth(200);

        Label labelAbrigos = new Label("Abrigos:");
        ComboBox<String> comboBoxAbrigos = new ComboBox<>();
        comboBoxAbrigos.getItems().addAll("Abrigo Feliz", "Lar dos Cãezinhos");

        Button buttonEnviarMensagem = new Button("Enviar Mensagem");
        TextField textFieldMensagem = new TextField();

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        GridPane.setConstraints(labelNome, 0, 0);
        GridPane.setConstraints(textFieldNome, 1, 0);
        GridPane.setConstraints(labelIdade, 0, 1);
        GridPane.setConstraints(spinnerIdade, 1, 1);
        GridPane.setConstraints(labelTemperamento, 0, 2);
        GridPane.setConstraints(textFieldTemperamento, 1, 2);
        GridPane.setConstraints(labelHistoria, 0, 3);
        GridPane.setConstraints(textAreaHistoria, 1, 3);
        GridPane.setConstraints(buttonCriarPerfil, 1, 4);
        GridPane.setConstraints(listViewPerfis, 2, 0, 1, 5);
        GridPane.setConstraints(labelAbrigos, 0, 5);
        GridPane.setConstraints(comboBoxAbrigos, 1, 5);
        GridPane.setConstraints(textFieldMensagem, 0, 6);
        GridPane.setConstraints(buttonEnviarMensagem, 1, 6);

        gridPane.getChildren().addAll(labelNome, textFieldNome, labelIdade, spinnerIdade,
                labelTemperamento, textFieldTemperamento, labelHistoria, textAreaHistoria, buttonCriarPerfil,
                listViewPerfis, labelAbrigos, comboBoxAbrigos, textFieldMensagem, buttonEnviarMensagem);

        // Evento do botão para criar perfil
        buttonCriarPerfil.setOnAction(e -> criarPerfil(textFieldNome.getText(), spinnerIdade.getValue(),
                textFieldTemperamento.getText(), textAreaHistoria.getText()));

        // Evento do botão para enviar mensagem
        buttonEnviarMensagem.setOnAction(e -> enviarMensagem(listViewPerfis.getSelectionModel().getSelectedItem(),
                textFieldMensagem.getText()));

        // Cena
        Scene scene = new Scene(gridPane, 500, 400);
        primaryStage.setScene(scene);

        // Exibir a janela
        primaryStage.show();
    }

    private void criarPerfil(String nome, int idade, String temperamento, String historia) {
        String perfil = "Nome: " + nome + ", Idade: " + idade + ", Temperamento: " + temperamento + ", História: " + historia;
        perfisList.add(perfil);
        System.out.println("Perfil criado com os seguintes dados:\n" + perfil);
    }

    private void enviarMensagem(String perfilSelecionado, String mensagem) {
        if (perfilSelecionado != null) {
            System.out.println("Mensagem enviada para o perfil:\n" + mensagem);
        }
    }
}
