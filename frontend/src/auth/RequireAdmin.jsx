import { Navigate } from "react-router-dom";
import { useAuth } from "./AuthContext";

export default function RequireAdmin({ children }) {
  const { auth } = useAuth();

  if (!auth) return <Navigate to="/login" />;
  if (auth.role !== "ROLE_ADMIN") return <Navigate to="/unauthorized" />;

  return children;
}
