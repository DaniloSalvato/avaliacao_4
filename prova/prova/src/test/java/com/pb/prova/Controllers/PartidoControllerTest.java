package com.pb.prova.Controllers;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PartidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void devolve201SeAdicionarUmPartido() throws Exception {
        URI uri = new URI("/partidos");
        String json = "{" +
                "\"nomeDoPartido\":\"Partido dos Unidos da Vila Maria\"," +
                "\"sigla\":\"PUVM\"," +
                "\"ideologia\":\"CENTRO\"," +
                "\"dataDeFundacao\":\"1988-06-25\"" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }

    @Test
    public void devolve400SeNaoAdicionarUmNovoPartido() throws Exception {
        URI uri = new URI("/partidos");
        String json = "{" +
                "\"nomeDoPartido\":\"Partido da Social Democracia Brasileira\"," +
                "\"sigla\":\"PSDB\"," +
                "\"ideologia\":\"CENTRO\"," +
                "\"dataDeFundacao\":\"25/06/1988\"" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void devolve200EListaTodosOsPartidos() throws Exception {
        URI uri = new URI("/partidos");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void devolve404SeOIdNaoExistir() throws Exception {
        URI uri = new URI("/partidos/122");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void devolve200SeOPartidoForDeletado() throws Exception {
        URI uri = new URI("/partidos/1");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void devolve404SeOIdDoPartidoNaoExistir() throws Exception {
        URI uri = new URI("/partidos/123");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void devolve200SeAtualizarUmPartido() throws Exception {
        URI uri = new URI("/partidos/2");
        String json = "{" +
                "\"nomeDoPartido\":\"Testando\"," +
                "\"sigla\":\"ABCD\"," +
                "\"ideologia\":\"ESQUERDA\"," +
                "\"dataDeFundacao\":\"1988-06-25\"" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void devolve400SeNaoAtualizarUmPartido() throws Exception {
        URI uri = new URI("/associados/1");
        String json = "{" +
                "\"nomeDoPartido\":\"\"," +
                "\"sigla\":\"ABCD\"," +
                "\"ideologia\":\"ESQUERDA\"," +
                "\"dataDeFundacao\":\"1988-06-25\"" +
                "}";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

}
