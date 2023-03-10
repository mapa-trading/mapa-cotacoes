package io.github.mapatrading.cotacoes.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorObject {

  private final String message;
  private final String field;
  private final Object parameter;
}