package isel.mpd.painter2.model;

import java.awt.*;

public interface IShape {
    // retorna a côr da forma
    Color getColor();
    // retorna o ponto de referência da forma.
    // Por exemplo, num círculo, o ponto de referência será o centro, num
    // rectângulo será o canto superior esquerdo
    Point getRef();
    // retorna true se a instância de IShape intersectar com other
    boolean intersects(IShape other);
    // retorna true se point estiver contido na instância de shape
    boolean contains(Point point);
    // retorna true se other estiver contido na instância de IShape
    boolean contains(IShape other);
    // desloca IShape de dx, dy
    void translate(int dx, int dy);
    // retorna uma instância de Rectangle que representa a área rectangular
    // que contém a instância de IShape
    Rectangle getBounds();
}
