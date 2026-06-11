import 'react';

// Компонент List, который использует render prop
const List = ({ items, renderItem }) => {
  return (
    <ul style={{ listStyleType: 'none', padding: 0 }}>
      {items.map((item, index) => {
        // Вызываем переданную функцию для каждого элемента массива
        return renderItem(item, index);
      })}
    </ul>
  );
};

export default List;
