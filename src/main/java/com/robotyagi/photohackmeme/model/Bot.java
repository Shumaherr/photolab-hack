package com.robotyagi.photohackmeme.model;

import com.microsoft.azure.storage.StorageException;
import com.robotyagi.photohackmeme.service.FileService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.InvalidKeyException;


@Service
public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "memeficator_bot";
    }

    @Override
    public String getBotToken() {
        return "758153614:AAGmxQgNclxVgJV-lrs1pbHuNDQs8-J_0Ro";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            if (message.getText().equals("/help"))
                sendMsg(message, "Привет, я подберу мем, отражающий твои эмоции. Отправь мне фото");
            else
                sendMsg(message, "Я не знаю что ответить на это");
        }
        if(message.hasPhoto())
        {
            for(PhotoSize o:message.getPhoto())
            {
                System.out.println(o.getFileId());

            }
            try {
                FileService.uploadFile("test.jpg", message.getPhoto().get(message.getPhoto().size() - 1).getFileId(), this, message.getPhoto().size());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (StorageException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }

        }
    }

    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



}