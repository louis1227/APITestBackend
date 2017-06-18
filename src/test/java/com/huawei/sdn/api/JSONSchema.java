package com.huawei.sdn.api;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.examples.Utils;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

public class JSONSchema {
  @Test
  public void f() throws IOException, ProcessingException {
	  
	  
	  
	  final JsonNode api = Utils.loadResource("d:/api.json");
      final JsonNode api2 = Utils.loadResource("d:/api2.json");

      final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

      final JsonSchema schema = factory.getJsonSchema(api);

      ProcessingReport report;

      report = schema.validate(api2);
      System.out.println(report);
  }
}
