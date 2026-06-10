import { useState } from 'react';
// Импортируем необходимые компоненты из Material UI
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';

function TextDisplayForm() {
  // Состояние для хранения текущего значения в поле ввода
  const [inputText, setInputText] = useState('');
  
  // Состояние для хранения текста, который нужно отобразить в карточке
  const [displayedText, setDisplayedText] = useState('');

  // Обработчик нажатия на кнопку
  const handleDisplayClick = () => {
    setDisplayedText(inputText);
  };

  return (
    <Box sx={{ maxWidth: 500, margin: '20px auto', padding: 2 }}>
      {/* 1. Поле ввода на всю ширину с меткой */}
      <TextField
        label="Введите текст"
        fullWidth
        variant="outlined"
        value={inputText}
        onChange={(e) => setInputText(e.target.value)}
      />

      {/* 2. Кнопка под полем ввода */}
      <Button
        variant="contained"
        color="primary"
        fullWidth
        onClick={handleDisplayClick}
        sx={{ mt: 2, mb: 3 }} // Отступы сверху и снизу через систему стилей MUI
      >
        Отобразить текст
      </Button>

      {/* 3. Отображение текста в стилизованной карточке (только если текст не пустой) */}
      {displayedText && (
        <Card variant="outlined" sx={{ backgroundColor: '#f9f9f9', boxShadow: 1 }}>
          <CardContent>
            {/* Использование Typography с вариантом h5 */}
            <Typography variant="h5" component="div" sx={{ wordBreak: 'break-word' }}>
              {displayedText}
            </Typography>
          </CardContent>
        </Card>
      )}
    </Box>
  );
}

export default TextDisplayForm;
