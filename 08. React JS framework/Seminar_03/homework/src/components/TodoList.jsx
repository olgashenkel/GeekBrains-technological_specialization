import { useState } from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';
import Card from '@mui/material/Card';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

function TodoList() {
  const [todos, setTodos] = useState([]);
  const [task, setTask] = useState('');

  // Функция добавления задачи
  const handleAddTask = () => {
    if (task.trim() === '') return; // Проверка на пустую строку

    const newTodo = {
      id: Date.now(), // Генерируем уникальный ID на основе времени
      text: task
    };

    setTodos([...todos, newTodo]);
    setTask(''); // Очищаем поле ввода
  };

  // Функция удаления задачи по ID
  const handleDeleteTask = (id) => {
    setTodos(todos.filter(todo => todo.id !== id));
  };

  return (
    <Box sx={{ maxWidth: 500, margin: '30px auto', padding: 2 }}>
      <Typography variant="h5" gutterBottom sx={{ textAlign: 'center', mb: 3 }}>
        Список задач (Todo)
      </Typography>

      {/* Форма ввода и кнопка добавления */}
      <Box sx={{ display: 'flex', gap: 1, mb: 3 }}>
        <TextField
          label="Новая задача"
          variant="outlined"
          fullWidth
          value={task}
          onChange={(e) => setTask(e.target.value)}
          onKeyDown={(e) => e.key === 'Enter' && handleAddTask()} // Добавление по Enter
        />
        <Button variant="contained" color="primary" onClick={handleAddTask}>
          Добавить
        </Button>
      </Box>

      {/* Список добавленных задач завернутых в Card */}
      <Card variant="outlined">
        <List dense>
          {todos.length === 0 ? (
            <ListItem sx={{ justifyContent: 'center', py: 2 }}>
              <Typography color="text.secondary">Список задач пуст</Typography>
            </ListItem>
          ) : (
            todos.map((todo) => (
              <ListItem
                key={todo.id}
                divider
                secondaryAction={
                  <IconButton edge="end" aria-label="delete" onClick={() => handleDeleteTask(todo.id)}>
                    <DeleteIcon color="error" />
                  </IconButton>
                }
              >
                <ListItemText primary={todo.text} />
              </ListItem>
            ))
          )}
        </List>
      </Card>
    </Box>
  );
}

export default TodoList;
