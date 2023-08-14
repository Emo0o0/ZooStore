package com.example.zoostore.api.base;

public interface OperationProcessor<Input extends OperationInput, Response extends OperationResult> {
    Response process(Input input);
}
