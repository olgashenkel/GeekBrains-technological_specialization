import { useState } from 'react';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

function TemperatureConverter() {
  const [celsius, setCelsius] = useState('');
  const [fahrenheit, setFahrenheit] = useState('');

  // Конвертация из Цельсия в Фаренгейт: (C * 9/5) + 32
  const handleCelsiusChange = (e) => {
    const value = e.target.value;
    setCelsius(value);
    
    if (value === '') {
      setFahrenheit('');
    } else {
      const converted = (parseFloat(value) * 9) / 5 + 32;
      setFahrenheit(isNaN(converted) ? '' : converted.toFixed(1));
    }
  };

  // Конвертация из Фаренгейта в Цельсий: (F - 32) * 5/9
  const handleFahrenheitChange = (e) => {
    const value = e.target.value;
    setFahrenheit(value);

    if (value === '') {
      setCelsius('');
    } else {
      const converted = ((parseFloat(value) - 32) * 5) / 9;
      setCelsius(isNaN(converted) ? '' : converted.toFixed(1));
    }
  };

  return (
    <Box sx={{ maxWidth: 400, margin: '30px auto', padding: 3, boxShadow: 2, borderRadius: 2, bgcolor: 'background.paper' }}>
      <Typography variant="h5" gutterBottom sx={{ textAlign: 'center', mb: 3 }}>
        Конвертер температур
      </Typography>
      
      <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
        <TextField
          label="Градусы Цельсия (°C)"
          type="number"
          fullWidth
          value={celsius}
          onChange={handleCelsiusChange}
        />
        <TextField
          label="Градусы Фаренгейта (°F)"
          type="number"
          fullWidth
          value={fahrenheit}
          onChange={handleFahrenheitChange}
        />
      </Box>
    </Box>
  );
}

export default TemperatureConverter;
