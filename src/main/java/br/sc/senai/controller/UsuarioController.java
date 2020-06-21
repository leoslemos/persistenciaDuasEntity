package br.sc.senai.controller;

import br.sc.senai.model.Usuario;
import br.sc.senai.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Isto indica que esta classe é um Controller
@RequestMapping(path = "/usuarios") // Isto indica que a URL deve conter o caminho /usuario após a URL principal da aplicação
public class UsuarioController {

    // Isto significa obter automaticamente o objeto usuárioRepository,
    // que é gerado automaticamente pelo Spring. Vamos usá-lo para manipular os dados (DAO).
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(path = "/add") // Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody
    String addNewUser
            (@RequestParam String nome, @RequestParam String email, @RequestParam String senha){
        Usuario user = new Usuario();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        usuarioRepository.save(user);
        return  "Usuario salvo no banco de dados";
    }

    @PostMapping(path = "/remove")// Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody
    String removeUser(@RequestParam Integer id){
        // @ResponseBody significa que a String retornada é a resposta
        // @RequestParam significa que é um parâmetro da solicitação GET ou POST

        usuarioRepository.deleteById(id);
        return "Usuario excluido do banco de dados";
    }

    @PostMapping(path ="/update")// Endpoint que recebe apenas requisições POST para inclusão de usuários
    public @ResponseBody
    String updateUser(@RequestParam Integer id, @RequestParam String nome, @RequestParam String email,
                      @RequestParam String senha){

        Usuario user = usuarioRepository.findById(id).get();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        usuarioRepository.save(user);
        return "Usuario com id "+user.getId()+" atualizado no banco de dados";
    }


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Usuario> findAll(){
        // @ResponseBody significa que a String retornada é a resposta
        // @RequestParam significa que é um parâmetro da solicitação GET ou POST
        return usuarioRepository.findAll();
    }

    @GetMapping(path = "/byName")
    public @ResponseBody
    Iterable<Usuario> findByName(@RequestParam String nome) {
        // @ResponseBody significa que a String retornada é a resposta
        // @RequestParam significa que é um parâmetro da solicitação GET ou POST
        return usuarioRepository.findAllByName(nome);
    }

}
