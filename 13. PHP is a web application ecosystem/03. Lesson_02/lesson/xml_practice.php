<?php
// Создаем корневой элемент
$xml = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><root></root>');

// Добавляем дочерние элементы (По примеру со стр. 15)
$person = $xml->addChild('person');
$person->addChild('name', 'Mr. Anderson');
$person->addChild('age', '33');
$person->addChild('city', 'New York');

echo "=== 1. Созданный XML-документ ===\n";
echo $xml->asXML() . "\n";

// Чтение XML из строки
$xmlString = '<person><name>Mr. Anderson</name><age>33</age></person>';
$parsedXml = simplexml_load_string($xmlString);

echo "=== 2. Парсинг XML ===\n";
echo "Имя из XML: " . $parsedXml->name . "\n";
