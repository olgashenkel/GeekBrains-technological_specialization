<?php

namespace App\Http\Controllers;

use App\Models\Product;
use Illuminate\Http\Request;

class ProductController extends Controller
{
    public function index()
    {
        return response()->json(Product::all());
    }

    public function store(Request $request)
    {
        $validated = $request->validate([
            'sku' => 'required|string|unique:products,sku',
            'name' => 'required|string',
            'price' => 'required|numeric',
        ]);

        $product = Product::create($validated);
        return response()->json($product, 201);
    }

    public function show(Product $product)
    {
        return response()->json($product);
    }

    public function update(Request $request, Product $product)
    {
        $validated = $request->validate([
            'sku' => 'string|unique:products,sku,' . $product->id,
            'name' => 'string',
            'price' => 'numeric',
        ]);

        $product->update($validated);
        return response()->json($product);
    }

    public function destroy(Product $product)
    {
        // Физически удаляем товар из базы данных
        $product->delete();

        // Возвращаем правильный статус 204 (No Content) для REST API
        return response()->noContent();
    }
}
