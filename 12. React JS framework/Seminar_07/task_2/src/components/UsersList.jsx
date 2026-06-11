import "react";
import { useDispatch, useSelector } from "react-redux";

export default function UsersList() {
  const dispatch = useDispatch();

  const data = useSelector((state) => state.users?.data || []);
  const loading = useSelector((state) => state.users?.loading || false);
  const error = useSelector((state) => state.users?.error || null);

  const loadUsers = () => {
    dispatch({ type: "FETCH_USERS_REQUEST" });
  };

  return (
    <div style={{ padding: "20px" }}>
      <button onClick={loadUsers} disabled={loading}>
        {loading ? "Загрузка..." : "Загрузить пользователей"}
      </button>

      {error && <p style={{ color: "red" }}>Ошибка: {error}</p>}

      <ul>
        {data &&
          data.map((user) => (
            <li key={user.id}>
              {user.name} ({user.email})
            </li>
          ))}
      </ul>
    </div>
  );
}
