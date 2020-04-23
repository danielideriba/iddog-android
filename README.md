# idDog Android

> Projeto idDog para android

## Requirements

- minSdkVersion **16**
- targetSdkVersion **28**

## Tópicos
- Arquitetura usada MVVM + Dagger2 
- Gradle DSL
- Layouts desenvolvidos com constraint layout já com Androidx
- Render de imagens com glide
- Login e criação de usuário utilizando o Firebase Auth (Projeto vintulado a minha conta no firebase)
- Network com retrofit okhttp e converter GSON
- Debug com Stetho e Timber
- Testes com JUNIT4

## Bibliotecas usadas

[dagger2](https://github.com/google/dagger)<br />
[okhttp3](https://github.com/square/okhttp)<br />
[retrofit2](https://github.com/square/retrofit)<br />
[stetho-okhttp](https://github.com/facebook/stetho)<br />
[timber](https://github.com/JakeWharton/timber) <br />
[gson](https://github.com/google/gson)<br /><br />

## Considerações

1. Utilização da dog API para as imagens dos cachorros (https://dog.ceo/dog-api/)
2. O armazenamento do token do login é feito localmente utilizando o Sharedpref do android na key: USER_COLUMN_IDTOKEN
    Ex:. 
    ```groovy
    val sharedPrefs = context.getSharedPreferences(SHARE_PREFS_NAME, MODE_PRIVATE)
    print(sharedPrefs.getString(USER_COLUMN_IDTOKEN, ""))
   ```
     
3. No projeto na parte de testes só forem feito testes unitários
